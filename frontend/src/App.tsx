import { useEffect } from "react";
import "./App.css";
import {
  fetchProfile,
  fetchTopArtists,
  getAccessToken,
  redirectToAuthCodeFlow,
} from "./spotifyHelpers";

function App() {
  const code = new URLSearchParams(window.location.search).get("code");

  useEffect(() => {
    handleGetSpotifyInfo();
  }, []);

  const handleGetSpotifyInfo = async () => {
    if (code) {
      const accessToken = await getAccessToken(code);
      const profile = await fetchProfile(accessToken);
      const topArtists = await fetchTopArtists(accessToken);
      console.log(profile, topArtists);

      // TODO: send profile to backend
    }
  };

  const handleAuth = async () => {
    redirectToAuthCodeFlow();
  };

  return (
    <>
      <h1>Spotify Matcher</h1>

      {code && <p>code: {code}</p>}
      {!code && (
        <button
          onClick={handleAuth}
          style={{
            background: "lightgreen",
            color: "darkgreen",
          }}
        >
          Logg inn med Spotify
        </button>
      )}
    </>
  );
}

export default App;
