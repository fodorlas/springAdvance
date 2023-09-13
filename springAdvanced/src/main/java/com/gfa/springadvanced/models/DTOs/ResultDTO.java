package com.gfa.springadvanced.models.DTOs;

import java.util.List;

public class ResultDTO {

    private int page;
    private List<MoviesDTO> results;

    public ResultDTO() {
   }

    public ResultDTO(int page, List<MoviesDTO> results) {
        this.page = page;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MoviesDTO> getResults() {
        return results;
    }

    public void setResults(List<MoviesDTO> results) {
        this.results = results;
    }
}
