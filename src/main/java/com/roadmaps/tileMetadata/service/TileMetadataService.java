package com.roadmaps.tileMetadata.service;

import com.roadmaps.tileMetadata.api.model.TileMetadata;
import com.roadmaps.tileMetadata.exceptions.CustomException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TileMetadataService {
    private final List<TileMetadata> tileMetadataList;

    public TileMetadataService() throws IOException {
        tileMetadataList=new ArrayList<>();
        tileMetadataList.add(new TileMetadata(
                1,
                "California Weather & Seasons",
                "California_Weather_&_Seasons",
                "thumbnails/california_weather_n_seasons_thumbnail.png",
                "drawIOPNG/california_weather_n_seasons.drawio.png",
                true));
        tileMetadataList.add(new TileMetadata(
                2,
                "H1B to GC for Indians",
                "H1B_to_GC_for_Indians",
                "thumbnails/h1b_to_gc_thumbnail.png",
                "drawIOPNG/h1b_to_greencard.drawio.png",
                true));
        tileMetadataList.add(new TileMetadata(
                3,
                "Pregnancy Journey",
                "pregnancy_journeys",
                "thumbnails/pregnancy_thumbnail.png",
                "drawIOPNG/pregnancy.drawio.png",
                true));
        tileMetadataList.add(new TileMetadata(
                4,
                "Coming Soon",
                "Coming_Soon",
                "thumbnails/coming_soon.png",
                "thumbnails/coming_soon.png",
                false));
    }
    public Optional<TileMetadata> getData(int id) {
        Optional optional = Optional.empty();
        try {
        for (TileMetadata tileMetadata: tileMetadataList) {
            if(id == tileMetadata.getId()) {
                optional = Optional.of(tileMetadata);
                return optional;
            }
        }
        } catch (Exception e) {
            throw new CustomException("Error while fetching tile metadata");
        }
        return optional;
    }

    public List<TileMetadata> getTileMetadataList() {
        return tileMetadataList;
    }

//    private String getImgRef(String path) throws IOException {
//        ClassPathResource resource = new ClassPathResource(path);
//        Path imagesFolderPath = Paths.get(resource.getURI());
//
//        return path.getFileName().toString();
//    }
}
