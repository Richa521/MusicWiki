## MusicWiki:

MusicWiki is a comprehensive, unofficial Last.fm application that offers in-depth information and insights into a wide variety of music genres. The app is designed to provide users with detailed information about the different albums, artists, and tracks that are associated with each genre.

MusicWiki aims to be the ultimate destination for music lovers to discover, learn and enjoy the different genres of music in one place.

- Is an Android app that uses the Last.fm API to provide information on music genres, artists, albums, and tracks.
- Is built using Kotlin programming language, MVVM architecture, and coroutines for asynchronous API calls.
- Uses the Glide Image Library and Retrofit Library for image parsing and API calls, respectively.
- Displays a list of available genres on the HomeScreen/Mainactivity.
- Clicking on a genre takes the user to the GenreInfo Activity that displays a ViewPager with sections for top albums, top artists, and top tracks for the selected genre.
- Clicking on an album or artist item takes the user to the AlbumInfo or ArtistInfo Activity, respectively.
- Implements the MVVM architecture using clean architecture principles and the repository pattern for a single source of truth.
- Uses coroutines for background API calls and LiveData observation.
- Uses the ViewPager and Adapter concepts to display the split of Albums, Artists, and Tracks for a particular genre.

## Decisions & Assumptions -
- Changed the initial UI of the app from TabLayout to RecyclerView for displaying all topTags/topGenres.
- Used Retrofit library instead of Volley library.
- Did not focus much on UI due to time constraints, keeping it minimalistic.
- Created many data classes due to API changes, making them un-reusable.
- Images not visible for Artists and Tracks section due to API limitations.
- Displays listener count instead of follower count in ArtistInfo Activity.
- Did not convert listener and play count to the nearest number to show them in 'k' format.

## Screenshots -
![Screenshot_20230322_144354_MusicWiki](https://user-images.githubusercontent.com/77117631/226857914-971070da-c9fd-411b-88e2-3fe61ec03e0d.jpg =250x250)

![Screenshot_20230322_144401_MusicWiki](https://user-images.githubusercontent.com/77117631/226858003-bd64d20e-cef9-420f-9a83-354755e8993c.jpg)

![Screenshot_20230322_144413_MusicWiki](https://user-images.githubusercontent.com/77117631/226858120-8e477299-b209-4e40-b140-a22f6a6d103a.jpg)

![Screenshot_20230322_144649_MusicWiki](https://user-images.githubusercontent.com/77117631/226858188-e6b4b910-60eb-47c6-9acd-ada1bc2fa9ba.jpg)

![Screenshot_20230322_145454_MusicWiki](https://user-images.githubusercontent.com/77117631/226858613-1a541cfc-0189-41dd-ba6f-1fe35761d5ac.jpg)

![Screenshot_20230322_144432_MusicWiki](https://user-images.githubusercontent.com/77117631/226858652-41e34210-1fae-410b-b662-1af8255deab6.jpg)

![Screenshot_20230322_144901_MusicWiki](https://user-images.githubusercontent.com/77117631/226858693-052b5f43-bd36-4794-9bc3-623610785969.jpg)

