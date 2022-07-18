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
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;

/**
 * The Main Activity.
 *
 * @author Cross.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * UserViewModel.
     */
    private UserViewModel userViewModel;

    /**
     * The onCreate instance.
     *
     * @param savedInstanceState instance.
     */
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the Recycler View from the layout.
        RecyclerView recyclerView = findViewById(R.id.am_rv_twins);

        // The Layout of the Recycler View.
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        // Build the adapter.
        UserAdapter adapter = new UserAdapter();

        // Set the adapter to RecyclerView.
        recyclerView.setAdapter(adapter);

        // Menu in MaterialToolbar.
        // TODO: fix the toolbar.
        // MaterialToolbar toolbar = findViewById(R.id.am_mt_toolbar);
        // toolbar.setOnMenuItemClickListener(menuItem -&gt; {
        //     // Click to change themes.
        //     if (menuItem.getItemId() == R.id.menu_theme) {
        //         // Check the current theme in use.
        //         if (AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_YES) {
        //             AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        //         } else {
        //             AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        //         }
        //
        //     }
        //
        // }

        // Build the UserViewModel.
        this.userViewModel = ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(super.getApplication())
                .create(UserViewModel.class);

        // Watch the view model.
        userViewModel.getUserLiveData().observe(this, user -> {

            // Update the adapter.
            adapter.setUser(user);

            // Refresh the GUI.
            adapter.notifyDataSetChanged();
        });

    }

    /**
     * Show the app.
     */
    @Override
    protected void onStart() {
        super.onStart();
        // Load data from the backend.
        userViewModel.update();
    }
}
