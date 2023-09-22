import { backendUrl } from "../const";

type ProfileData = {
  spotifyUserId: string,
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
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(profileData),
  });
};

export const saveTopArtists = async (userId: String, topArtists: TopArtists) => {
  return await fetch(`${backendUrl}/${userId}/artists`, {
    method: "POST",
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(topArtists),
  });
};
