package com.roadmaps.tileMetadata.api.controller;

import com.roadmaps.tileMetadata.api.model.TileMetadata;
import com.roadmaps.tileMetadata.service.TileMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TileMetadataController {
    private TileMetadataService tileMetadataService;

    @Autowired
    public TileMetadataController(TileMetadataService tileMetadataService){
        this.tileMetadataService = tileMetadataService;
    }
    @GetMapping("/tile")
    public TileMetadata getTileMetadataById(@RequestParam int id) {
        Optional tileMetadata = tileMetadataService.getData(id);
        if (tileMetadata.isPresent()) {
            return (TileMetadata) tileMetadata.get();
        }
        return null;
    }

    @GetMapping("/tiles")
    public List<TileMetadata> getTileMetadataList() {
        return tileMetadataService.getTileMetadataList();
    }

}
