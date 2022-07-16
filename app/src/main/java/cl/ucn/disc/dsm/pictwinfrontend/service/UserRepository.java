/*
 * Copyright 2022 Tomas Venegas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package cl.ucn.disc.dsm.pictwinfrontend.service;

import cl.ucn.disc.dsm.pictwinfrontend.model.User;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Repository of User.
 *
 * @author Cross.
 */
@Slf4j
public final class UserRepository {

    /**
     * The REST API.
     */
    private final PicTwinAPIRest apiRest;

    // Internal IP address.
    private static final String BASE_URL = "http://192.168.16.1:8080";

    /**
     * Constructor.
     */
    public UserRepository() {

        log.debug("Building UserRepository with URL: {}", BASE_URL);

        // Optional: the logger.
        HttpLoggingInterceptor theLogging = new HttpLoggingInterceptor(log::debug);
        theLogging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Optional: the OkHttp.
        OkHttpClient theClient = new OkHttpClient.Builder()
                .addInterceptor(theLogging)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .callTimeout(50, TimeUnit.SECONDS)
                .build();

        // Retrofit.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(theClient)
                .build();

        // The REST API.
        this.apiRest = retrofit.create(PicTwinAPIRest.class);
    }

    /**
     * Retrieve a user from PicTwin REST API.
     *
     * @param email to use.
     * @param password to use.
     * @return the user.
     */
    public Optional<User> retrieveUser(final String email, final String password) {

        // The call.
        Call<User> cUser = this.apiRest.retrieveUser(email, password);

        try {
            // The execution.
            Response<User> rUser = cUser.execute();

            // Code in 2xx range.
            if (rUser.isSuccessful()) {

                // Check for body.
                if (rUser.body() == null) {
                    return Optional.empty();
                }

                // Return the User.
                return Optional.of(rUser.body());
            }

            // An unknown error.
            throw new RuntimeException("Can't retrieve user", new HttpException(rUser));
        } catch (IOException ex) {
            // IO error.
            throw new RuntimeException("Can't retrieve user", ex);
        }
    }
}
