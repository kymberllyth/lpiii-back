package com.fiec.lpiiiback.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class FirebaseResponseDto {
    String idToken;
    String email;
    String refreshToken;
    String expiresIn;
    String localId;
    String registered;
}

/*

idToken	string	A Firebase Auth ID token for the authenticated user.
email	string	The email for the authenticated user.
refreshToken	string	A Firebase Auth refresh token for the authenticated user.
expiresIn	string	The number of seconds in which the ID token expires.
localId	string	The uid of the authenticated user.
registered	boolean	Whether the email is for an existing account.
 */