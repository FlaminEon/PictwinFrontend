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

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Pic class
 *
 * @author Cross.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pic {

    /**
     * The ID of the Pic.
     */
    @Getter
    private Long id;

    /**
     * The timestamp.
     */
    @Getter
    @Builder.Default
    private ZonedDateTime timestamp = ZonedDateTime.now();

    /**
     * the amount of dislike a Pic has.
     */
    @Getter
    @Builder.Default
    private Integer dislikes = 0;

    /**
     * The geographical latitude of the Pic.
     */
    @Getter
    private Double latitude;

    /**
     * The geographical longitude of the Pic.
     */
    @Getter
    private Double longitude;

    /**
     * The GPS' error.
     */
    @Getter
    private Double error;

    /**
     * The amount of views a Pic has.
     */
    @Getter
    @Builder.Default
    private Integer views = 0;

    /**
     * The name of the Pic.
     */
    @Getter
    private String name;

    /**
     * The stored picture in Bytes
     */
    @Getter
    private Byte[] picture;

    /**
     * The owner of the Pic
     */
    @Getter
    @Setter
    private User owner;

    /**
     * Increment the amount of dislikes
     *
     * @return the amount of dislikes
     */
    public Integer incrementDislikes(){
        this.dislikes++;
            return this.dislikes;
    }

    /**
     * Increment the amount of views
     *
     * @return the amount of views.
     */
    public Integer incrementViews(){
        this.views++;
        return this.views;
    }
}
