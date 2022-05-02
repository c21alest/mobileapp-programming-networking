
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
_Figur 1.1 XML för layout av Recycler View_

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
och den data vi vill skicka med, i detta fall kan man använda "Tracks" som är en variabel som används som test under implementeringen av recycler viewn eller den senare json datan som kommer behandlas.
Slutligen kopplar vi både adaptern och layout managern till reycler viewn.

```
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
_Figur 2.1 Kod för att instansiera Reycler View_

## Reycler View Adapter
När man har instansierat recycler viewn behöver adaptern skapas. Detta görs i en egen klass där
tre huvudaskliga metoder skapas nämligen onCreateViewHolder, onBindViewHolder, getItemCount. Där onCreateViewHolder just skapar
en view holder så länge ingen annan existerar. Och onBindViewHolder tar hand om de olika vyerna som skapas, en recycler view har i
uppgift att vara ett mer effektiv sett att hantera vyer genom att återanvända dem och inte visa alla samtidigt, just 
för att spara minne, och denna metod hanterar dessa vyer. Metoden getItemCount är simpel och berättar just hur många objekt som finns.
I dessa olika metoder kan man sedan specifisiera vad som exakt ska hända men som syns i koden nedan (se där kod kommentarer).

```
    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Skapar en ny view för list_items som används för att presentera innehåller i recycler view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        // Hämtar varje element i array
        holder.textD.setText(Tracks.get(position));
    }

    @Override
    public int getItemCount() {
        return Tracks.size();
    }
```
_Figur 3.1 Metoder för Recycler View_

I denna adapter klas behöver man i detta fallet också berätta vilken data som ska finnas i recycler view. I detta fallet vill man
ha den array som kommer att skapas i activity main, detta syns i kod nedan.

````
    // Skapar array som kommer från main activity
    ArrayList<String> Tracks;
    public MainAdapter(ArrayList<String> tracks) {
        Tracks = tracks;
    }
````
_Figur 3.2 Kod för att länka array_

Slutligen så skapas en view holder som kopplas mot ett id för var datan kan presenteras, detta syns i kod nedan.

````
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textD;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Kopplar variabel mot id i en layout
            textD = itemView.findViewById(R.id.display_text);
        }
    }
````
_Figur 3.3 Kod för View Holder_

## JSON data
För att java ska kunna hantera JSON data måste de olika array elementen kopplas på klasser. Däför skapas ytterligare en klass som heter mountin som
sparar alla värden i strängar (se figur 4.1), sedan kan man med hjälp av dessa klasser hämta den data man vill ha. I koden som syns nedan skapas ett antal privata strängar
som sedan med hjälp av olika getters kan skicka denna data till de funktioner som kallar på den. Här finns också en funktion för varje getter som behandlar null
värden. Eftersom inte null beskrivs per automatik ges null värdet om strängen inte innehåller något alls. Sedan kan man i ta bort alla värden i arrayen
som har noll, vilket i detta fallet görs i main och syns lite längre ner (figur 4.2).

```
public class Mountain {
    private String ID;
    private String name;
    private String type;
    private String company;
    private String location;
    private String category;
    private String size;
    private String cost;
    private Auxdata auxdata;

    public String getName() {
        // Om tomt skickas null annars hela oridinarie värde
        if (name.equals("")) {
            return null;
        }
        else {
            return name;
        }
    }

    public String getID() {
        if (ID.equals("")) {
            return null;
        }
        else {
            return ID;
        }
    }
  (...)
}
```
_Figur 4.1 Kod för getters_

```
        // Tar bort alla null värden från array
        while (MountainsA.remove(null)) {}
```
_Figur 4.2 Kod för att ta bort null värden_


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
