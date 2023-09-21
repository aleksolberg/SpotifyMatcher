import { redirectToAuthCodeFlow } from "../lib/spotifyHelpers";
import "./../App.css";

function Index() {
  const handleAuth = async () => {
    redirectToAuthCodeFlow();
  };

  return (
    <>
      <h1>Spotify Matcher</h1>

      <button
        onClick={handleAuth}
        style={{
          background: "lightgreen",
          color: "darkgreen",
        }}
      >
        Logg inn med Spotify
      </button>
    </>
  );
}

export default Index;
