package com.molvaoffice.autoservice.domain.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConvertableDTO {

    public List<ConvertableObject> data;
}
