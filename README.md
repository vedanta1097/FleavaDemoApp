# FleavaDemoApp
Demo Android app for applying Android position at Fleava.
<br/>This app was tested on <strong>Nexus 5X API 28</strong> emulator.

## API
<ul>
  <li><a href="https://reqres.in/">REQ | RES</a> - I use reqres for login feature because the link and credential given in the email keep getting error code 400. So I use this API to simulate successful login, user can input anything for the email and password.</li>
  <li><a href="https://developers.themoviedb.org/3/movies/get-popular-movies">The Movie Database (TMDb)</a> - I use TMDb as dummy data to fill the content list in the mockups. </li>
</ul>

## Library
<ul>
  <li><a href="https://square.github.io/retrofit/">Retrofit</a> - to performs HTTP requests against list of API mentioned in the above.</li>
  <li><a href="https://github.com/bumptech/glide">Glide</a> - to load image into ImageView.</li>
  <li><a href="https://github.com/jgabrielfreitas/BlurImageView">BlurImageView</a> - to give blue effect for to the background in the login page.</li>
  <li><a href="https://github.com/hdodenhof/CircleImageView">CircleImageView</a> - to show circle image in the content list</li>
</ul>

## Screenshot
<image src="https://user-images.githubusercontent.com/17045245/51553513-00519480-1eae-11e9-86d4-41256aeda562.jpg" width=200/>
<image src="https://user-images.githubusercontent.com/17045245/51553692-6a6a3980-1eae-11e9-8bfd-9c899d98b208.jpg" width=200/>
<image src="https://user-images.githubusercontent.com/17045245/51554415-3859d700-1eb0-11e9-8675-be1585e4870b.jpg" width=200/>

## Unsolved Problem 
<ul>
  <li>I still cant find a way to replace android default shadow with the shadow similar in the mockups. (See facebook and VK button in screenshots)</li>
  <li>Can't apply gradient background to Floating Action Button (filter icon in top right corner) because FAB's background attribute only accept color resource (solid color) not drawable resource. (Gradient color only can be created with drawable resource)</li>
  <li>The "Spirit" text in the top left corner of mockups cant be included inside RecyclerView. So I just put it in the Tool Bar</li>
  <li>Can't apply gradient color to BottomNavigationView's icon because it only accept solid color from color resource as background color.</li>
</ul>
