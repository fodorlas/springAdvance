package com.gfa.springadvanced.controllers;


import com.gfa.springadvanced.models.DTOs.MoviesDTO;
import com.gfa.springadvanced.models.DTOs.ResultDTO;
import com.gfa.springadvanced.services.UserService;
import com.gfa.springadvanced.services.retrofitServices.ApiRetrofitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class ApiController {

    private final UserService userService;
    private final ApiRetrofitServices apiRetrofitServices;
    private final String apiKey = "e0a94ad12e5bb18854f2b7245907b48a";
    @Autowired
    public ApiController(UserService userService, ApiRetrofitServices apiRetrofitServices) {
        this.userService = userService;
        this.apiRetrofitServices = apiRetrofitServices;
    }

//    @GetMapping("/movies")
//    public ResponseEntity<?> listMovies(){
//        Call<List<MoviesDTO>> call = apiRetrofitServices.listMovies("deadpool");
//        Response<List<MoviesDTO>> response = null;
//        try {
//            response = call.execute();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        List<MoviesDTO> movies = response.body();
//        return ResponseEntity.ok(movies);
//    }

        @GetMapping("/movies")
        public ResponseEntity<?> listMovies() {
            Call<ResultDTO> call = apiRetrofitServices.listMovies(apiKey,"deadpool");

            try {
                Response<ResultDTO> response = call.execute();

                if (response.isSuccessful()) {
                    List<MoviesDTO> movies = response.body().getResults();
                    return ResponseEntity.ok(movies);
                } else {
                    // Handle API error here, e.g., return an error response
                    return ResponseEntity.status(response.code()).body("API request failed");
                }
            } catch (IOException e) {
                // Handle IO exception, e.g., return an error response
                return ResponseEntity.status(500).body("Internal Server Error");
            }
        }


}


//{
//    "page": 1,
//    "results": [
//        {
//            "adult": false,
//            "backdrop_path": "/en971MEXui9diirXlogOrPKmsEn.jpg",
//            "genre_ids": [
//                28,
//                12,
//                35
//            ],
//            "id": 293660,
//            "original_language": "en",
//            "original_title": "Deadpool",
//            "overview": "The origin story of former Special Forces operative turned mercenary Wade Wilson, who, after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.",
//            "popularity": 81.903,
//            "poster_path": "/zq8Cl3PNIDGU3iWNRoc5nEZ6pCe.jpg",
//            "release_date": "2016-02-09",
//            "title": "Deadpool",
//            "video": false,
//            "vote_average": 7.605,
//            "vote_count": 28841
//        },
//        {
//            "adult": false,
//            "backdrop_path": "/3P52oz9HPQWxcwHOwxtyrVV1LKi.jpg",
//            "genre_ids": [
//                28,
//                35,
//                12
//            ],
//            "id": 383498,
//            "original_language": "en",
//            "original_title": "Deadpool 2",
//            "overview": "Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life.",
//            "popularity": 72.581,
//            "poster_path": "/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg",
//            "release_date": "2018-05-10",
//            "title": "Deadpool 2",
//            "video": false,
//            "vote_average": 7.491,
//            "vote_count": 16283
//        },
//        {
//            "adult": false,
//            "backdrop_path": "/3M9ZKIx4khmyll2DGB5zil626UA.jpg",
//            "genre_ids": [
//                35,
//                28,
//                12
//            ],
//            "id": 567604,
//            "original_language": "en",
//            "original_title": "Once Upon a Deadpool",
//            "overview": "A kidnapped Fred Savage is forced to endure Deadpool's PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that's full of magic, wonder & zero F's.",
//            "popularity": 29.873,
//            "poster_path": "/5Ka49BWWyKMXr93YMbH5wLN7aAM.jpg",
//            "release_date": "2018-12-11",
//            "title": "Once Upon a Deadpool",
//            "video": false,
//            "vote_average": 7.2,
//            "vote_count": 642
//        },
//        {
//            "adult": false,
//            "backdrop_path": "/mbY234XwMwEofAdX8yddNcK82wi.jpg",
//            "genre_ids": [
//                28,
//                12,
//                35
//            ],
//            "id": 533535,
//            "original_language": "en",
//            "original_title": "Deadpool 3",
//            "overview": "The third installment in the Deadpool franchise.",
//            "popularity": 32.339,
//            "poster_path": "/4gdqWCVvidYR0pOHuVOqFundbUG.jpg",
//            "release_date": "2024-04-30",
//            "title": "Deadpool 3",
//            "video": false,
//            "vote_average": 0.0,
//            "vote_count": 0
//        },
//        {
//            "adult": false,
//            "backdrop_path": null,
//            "genre_ids": [
//                28,
//                35,
//                80
//            ],
//            "id": 558144,
//            "original_language": "en",
//            "original_title": "Deadpool: No Good Deed",
//            "overview": "Deadpool sees an opportunity to save the day, but it doesn't go entirely as planned.",
//            "popularity": 8.433,
//            "poster_path": "/7p1v2CMnEd0Hb3eFi0iEA6kDAMU.jpg",
//            "release_date": "2017-03-03",
//            "title": "Deadpool: No Good Deed",
//            "video": false,
//            "vote_average": 7.1,
//            "vote_count": 448
//        },
//        {
//            "adult": false,
//            "backdrop_path": null,
//            "genre_ids": [
//                28,
//                35
//            ],
//            "id": 1173935,
//            "original_language": "en",
//            "original_title": "Adventures of The Deadpool Uber Driver",
//            "overview": "This movie's plot is currently unknown.",
//            "popularity": 1.312,
//            "poster_path": null,
//            "release_date": "",
//            "title": "Adventures of The Deadpool Uber Driver",
//            "video": false,
//            "vote_average": 0.0,
//            "vote_count": 0
//        },
//        {
//            "adult": false,
//            "backdrop_path": null,
//            "genre_ids": [],
//            "id": 1154500,
//            "original_language": "en",
//            "original_title": "Deadpool: The Pang Cut",
//            "overview": "Deadpool tells the origin story of former Special Forces operative turned mercenary Ryan Wilson, who after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.",
//            "popularity": 0.96,
//            "poster_path": null,
//            "release_date": "",
//            "title": "Deadpool: The Pang Cut",
//            "video": false,
//            "vote_average": 0.0,
//            "vote_count": 0
//        }
//    ],
//    "total_pages": 1,
//    "total_results": 7
//}