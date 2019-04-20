Given the following urls:

Step O: Find the artist information using (
    http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&api_key\={0}&format\=json&artist\={1}
)

Step 1: Get the hottest playlist in a given country using (
    http://ws.audioscrobbler.com/2.0/?method=geo.gettoptracks&api_key={0}&country={1}&format=json
)

Step 2: for each song in the playlist, find the song details using (
    http://ws.audioscrobbler.com/2.0/?method=track.getInfo&api_key={0}&track={1}&artist={2}&format=json
)

Step 3: For each song find the Lyrics of the song using (
    https://api.musixmatch.com/ws/1.1/matcher.lyrics.get?apikey={0}&q_track={1}&q_artist={2}
)