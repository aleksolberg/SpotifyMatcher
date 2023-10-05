import { backendUrl } from "../const";

type ProfileData = {
  spotifyUserId: string;
  name: string;
  email: string;
  accessToken: string;
};

// TODO: Get types from Spotify SDK
type TopArtists = {
  name: string;
}[];

const headers = {
  "Content-Type": "application/json",
};

export const saveProfileData = async (profileData: ProfileData) => {
  return await fetch(backendUrl + "/users", {
    method: "POST",
    headers,
    body: JSON.stringify(profileData),
  });
};

export const saveTopArtists = async (
  userId: string,
  topArtists: TopArtists
) => {
  return await fetch(`${backendUrl}/users/${userId}/artists`, {
    method: "POST",
    headers,
    body: JSON.stringify(topArtists),
  });
};
