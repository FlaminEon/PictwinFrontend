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

/**
 * The REST API of PicTwin
 *
 * @author Cross
 */
public interface PicTwinAPIRest {

    /**
     * Retrieve the user.
     *
     * @param email to use.
     * @param password to use.
     * @return the user.
     */
    @GET("/users")
    Call<User> retrieveUser(@Query("email") String email, @Query(value = "password") String password);
}
