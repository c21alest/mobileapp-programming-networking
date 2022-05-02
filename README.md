
# Assignment 5: Networking

## Layout för Recycler View
Först lades en layout för Recycler View till, vilket delvis bestämmer designen för
hur recycler viewn ska presenteras. Detta görs i form av XML som syns nedan.
```
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginStart="10dp"
        android:layout_marginTop="10dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```
## Funktionen för Reycler View
En recycler view gör det möjligt att dynamiskt visa innehåll. Det vill säga att presentera data
oberoende av dess längd och storlek. För att skapa en recycler view krävs ett antal olika komponenter,
där de största är en adapter, view holder och en layout manager. Adaptern är den huvudsakliga komponenterna som presenterar
all data medans en view holder tar hand om varje individuellt element medans layout managern arrangerar alla dessa element.

Men först av allt skapades en instans, kod för detta syns nedan.
Man börjar med att skapa de olika variablerna. I fallet för kod nedan
får själva recyclerviewn variabeln "myRecyclerView". Sedan skapas adapter:n och slutligen layout manager:.
När detta är gjort länkas recyclerview:n mot ett id i layouten där datan kan presenteras.
Efter det länkas layout managern till den tidigare variabeln som skapades. Sen kopplas adaptern till en klass
och den data vi vill skicka med, i detta fall "Tracks" som är en variabel som används som test under implementeringen av recycler viewn.
Slutligen kopplar vi både adaptern och layout managern till reycler viewn.

´´´
    RecyclerView myRecyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager myLayoutManager;

    (...)

        // Skapar en recycler view instans
        myRecyclerView = findViewById(R.id.recycler_view);
        // Optimerings parameter
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        myAdapter = new MainAdapter(MountainsA);
        myRecyclerView.setAdapter(myAdapter);

```


## Följande grundsyn gäller dugga-svar:

- Ett kortfattat svar är att föredra. Svar som är längre än en sida text (skärmdumpar och programkod exkluderat) är onödigt långt.
- Svaret skall ha minst en snutt programkod.
- Svaret skall inkludera en kort övergripande förklarande text som redogör för vad respektive snutt programkod gör eller som svarar på annan teorifråga.
- Svaret skall ha minst en skärmdump. Skärmdumpar skall illustrera exekvering av relevant programkod. Eventuell text i skärmdumpar måste vara läsbar.
- I de fall detta efterfrågas, dela upp delar av ditt svar i för- och nackdelar. Dina för- respektive nackdelar skall vara i form av punktlistor med kortare stycken (3-4 meningar).

Programkod ska se ut som exemplet nedan. Koden måste vara korrekt indenterad då den blir lättare att läsa vilket gör det lättare att hitta syntaktiska fel.

```
function errorCallback(error) {
    switch(error.code) {
        case error.PERMISSION_DENIED:
            // Geolocation API stöds inte, gör något
            break;
        case error.POSITION_UNAVAILABLE:
            // Misslyckat positionsanrop, gör något
            break;
        case error.UNKNOWN_ERROR:
            // Okänt fel, gör något
            break;
    }
}
```

Bilder läggs i samma mapp som markdown-filen.

![](android.png)

Läs gärna:

- Boulos, M.N.K., Warren, J., Gong, J. & Yue, P. (2010) Web GIS in practice VIII: HTML5 and the canvas element for interactive online mapping. International journal of health geographics 9, 14. Shin, Y. &
- Wunsche, B.C. (2013) A smartphone-based golf simulation exercise game for supporting arthritis patients. 2013 28th International Conference of Image and Vision Computing New Zealand (IVCNZ), IEEE, pp. 459–464.
- Wohlin, C., Runeson, P., Höst, M., Ohlsson, M.C., Regnell, B., Wesslén, A. (2012) Experimentation in Software Engineering, Berlin, Heidelberg: Springer Berlin Heidelberg.
