package com.gfa.springadvanced.services;

import org.springframework.stereotype.Service;

@Service
public class MyApiServiceImpl {
}




//api key
//curl --request GET \
//     --url 'https://api.themoviedb.org/3/movie/11?api_key=e0a94ad12e5bb18854f2b7245907b48a'

// bearer token
//curl --request GET \
//     --url 'https://api.themoviedb.org/3/movie/11' \
//     --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlMGE5NGFkMTJlNWJiMTg4NTRmMmI3M
//     jQ1OTA3YjQ4YSIsInN1YiI6IjY1MDA0ZjBlNmEyMjI3MDEzNzJkNDVkZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9
//     uIjoxfQ.Nht5CN9Qtqr23VLNTcYBsjhxaZo0DAbeMOg6vB4ZjNo'