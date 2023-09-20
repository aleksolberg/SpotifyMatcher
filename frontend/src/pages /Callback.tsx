import { useEffect, useState } from "react";
import {
  fetchProfile,
  fetchTopArtists,
  getAccessToken,
} from "../lib/spotifyHelpers";
import "./../App.css";
import { saveProfileData, saveTopArtists } from "../lib/backendHelpers";

function Callback() {
  const code = new URLSearchParams(window.location.search).get("code");

  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    handleGetSpotifyInfo();
  }, []);

  const handleGetSpotifyInfo = async () => {
    if (code) {
      const accessToken = await getAccessToken(code);
      const profile = await fetchProfile(accessToken);
      const topArtists = await fetchTopArtists(accessToken);
      console.log(profile, topArtists);

      // Save data to backend
      try {
        await saveProfileData(profile);
        await saveTopArtists(topArtists);
      } catch (error) {
        console.log(error);
        setError("Kunne ikke lagre data til backend");
      }
    }
  };

  return (
    <>
      {code && <p>code: {code}</p>}
      {error && (
        <p
          style={{
            background: "lightcoral",
            color: "darkred",
            padding: "10px",
            borderRadius: "5px",
            border: "1px solid darkred",
          }}
        >
          {error}
        </p>
      )}
      {!code && (
        <>
          <p>Ingen kode</p>
          <a
            style={{
              background: "lightgreen",
              color: "darkgreen",
              padding: "10px",
              borderRadius: "5px",
            }}
            href="/"
          >
            ← Tilbake til forsiden
          </a>
        </>
      )}
    </>
  );
}

export default Callback;
