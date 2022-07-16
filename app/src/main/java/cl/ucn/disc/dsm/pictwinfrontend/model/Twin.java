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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Twin created from two Pics.
 *
 * @author Cross.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Twin {

    /**
     * The ID.
     */
    @Getter
    private Long id;

    /**
     * The dislike indicator.
     */
    @Getter
    @Setter
    @Builder.Default
    private Boolean dislike = Boolean.FALSE;

    /**
     * Pic tagged as "my".
     */
    @Getter
    private Pic my;

    /**
     * Pic tagged as "yours".
     */
    @Getter
    private Pic yours;

    /**
     * The owner of the twin.
     */
    @Getter
    private User owner;

}
