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

package cl.ucn.disc.dsm.pictwinfrontend.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * The User of the application.
 *
 * @author Cross
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class User {

    /**
     * The ID.
     */
    @Getter
    private Long id;

    /**
     * The user's email.
     */
    @Getter
    @NonNull
    private String email;

    /**
     * The user's amount of strikes
     */
    @Getter
    private Integer strikes;

    /**
     * The user's hashed password
     */
    @Getter
    @Setter
    private String password;

    /**
     * The Twins
     */
    // TODO: check Getter
    @Builder.Default
    @Getter
    private List<Twin> twins = new ArrayList<>();

    /**
     * The State.
     */
    @Builder.Default
    @Getter
    @Setter
    private State state = State.ACTIVE;

    /**
     * Increment the amount of strikes.
     *
     * @return the number of strikes.
     */
    public Integer incrementStrikes(){
        this.strikes++;
        return this.strikes;
    }

    /**
     * Insert a twin into the List.
     *
     * @param twin to add.
     */
    public void add(final Twin twin){
        this.twins.add(twin);
    }
}
