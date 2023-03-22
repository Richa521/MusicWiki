MusicWiki:

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


