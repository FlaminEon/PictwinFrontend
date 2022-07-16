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

package cl.ucn.disc.dsm.pictwinfrontend;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * The View Holder.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    //TODO: change class to static.
    protected TextView mine;

    protected TextView yours;

    /**
     * Shows both Twins.
     *
     * @param view a view.
     */
    public ViewHolder(View view) {
        super(view);
        this.mine = view.findViewById(R.id.rt_tv_mine);
        this.yours = view.findViewById(R.id.rt_tv_yours);
    }
}
