import { redirectToAuthCodeFlow } from "../lib/spotifyHelpers";

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
