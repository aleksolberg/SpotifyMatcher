import { backendUrl } from "../const";

type ProfileData = {
  name: string;
  email: string;
  accessToken: string;
};

// TODO: Get types from Spotify SDK
type TopArtists = {
  name: string;
}[];

export const saveProfileData = async (profileData: ProfileData) => {
  return await fetch(backendUrl + "/users", {
    method: "POST",
    body: JSON.stringify(profileData),
  });
};

export const saveTopArtists = async (topArtists: TopArtists) => {
  return await fetch(backendUrl + "/top-artists", {
    method: "POST",
    body: JSON.stringify(topArtists),
  });
};
