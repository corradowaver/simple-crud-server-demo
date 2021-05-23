package com.molvaoffice.autoservice.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

public interface Convertable {

    default ConvertableDTO convertToObjectWithTypes() {
        return new ConvertableDTO(
                List.of(this.getClass().getDeclaredFields())
                        .stream()
                        .map(field -> {
                            System.out.println(field);
                            field.setAccessible(true);
                            try {
                                return new ConvertableObject(field.getName(), field.getType().getSimpleName(), field.get(this));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            return null;
                        })
                        .collect(Collectors.toList())
        );
    }
}
