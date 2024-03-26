package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.Oferta;
import com.ug.ec.domain.SubArea;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class AreaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idArea;
    private String nombreArea;
    private List<Oferta> oferta = new ArrayList<>();
    private List<SubArea> subArea = new ArrayList<>();

}
