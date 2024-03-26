
package com.ug.ec.dto;

import java.io.Serializable;
import com.ug.ec.domain.Area;
import lombok.Data;

@Data
public class SubAreaDto implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private int idSubArea;
    private String nombreSubArea;
    private Area area;


}
