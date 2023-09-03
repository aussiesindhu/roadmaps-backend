package com.roadmaps.tileMetadata.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TileMetadata {
    int id;
    String text;
    String path;
    String imgRef;
    String flow;
    boolean clickable;
}
