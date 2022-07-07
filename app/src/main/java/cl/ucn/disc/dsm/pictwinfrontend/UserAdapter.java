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

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cl.ucn.disc.dsm.pictwinfrontend.model.Twin;
import cl.ucn.disc.dsm.pictwinfrontend.model.User;

/**
 * The adapter
 *
 * @author Cross.
 */
public final class UserAdapter extends RecyclerView.Adapter<ViewHolder> {
    // TODO: find a way to connect UserAdapter.ViewHolder here.
    /**
     * The User.
     */
    private User user;

    /**
     * The Constructor.
     */
    public UserAdapter(){
        // Nothing
    }

    /**
     * Called when RecyclerView needs a new {@Link ViewHolder} of the given type
     * to represent an item.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View twinView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.row_twin, parent, false);
        return new ViewHolder(twinView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of {@Link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        // Retrieve the Twin at the specified position
        final Twin twin = this.user.getTwins().get(position);

        // Update GUI
        holder.mine.setText(String.format("ID: %d", twin.getMy().getId()));
        holder.yours.setText(String.format("ID: %d", twin.getYours().getId()));
    }

    /**
     * Returns the total number of item in the data set held by the adapter
     *
     * @return the total number of items in this adapter
     */
    @Override
    public int getItemCount() {
        if (this.user == null) {
            return 0;
        }

        return this.user.getTwins().size();
    }

    /**
     * Set the user
     */
    public void setUser(@NonNull User user){
        this.user = user;
    }

}
