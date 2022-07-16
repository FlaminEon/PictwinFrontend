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

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cl.ucn.disc.dsm.pictwinfrontend.model.User;
import cl.ucn.disc.dsm.pictwinfrontend.service.UserRepository;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import lombok.Getter;

/**
 * The ViewModel of User.
 *
 * @author Cross.
 */
public class UserViewModel extends AndroidViewModel {

    /**
     * The executor with two threads.
     */
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(2);

    /**
     * The Repository.
     */
    private final UserRepository userRepository = new UserRepository();

    /**
     * The container of User.
     */
    @Getter
    private final MutableLiveData<User> userLiveData = new MutableLiveData<>();

    /**
     * The Constructor.
     *
     * @param application to use.
     */
    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Return the LiveData of User.
     */
    public void Update() {

        // Only load if there isn't any data
        if (this.userLiveData.getValue() == null) {
            this.retrieveUserFromNetworkInBackground();
        }
    }

    /**
     * Retrieve User from REST API in background.
     */
    private void retrieveUserFromNetworkInBackground() {

        // Run in background
        EXECUTOR.execute(() -> {

            // Get the User from repository.
            Optional<User> oUser = this.userRepository.retrieveUser("admin@ucn.cl", "admin123");

            // Only set the user if it exists.
            oUser.ifPresent(this.userLiveData::postValue);
        });
    }
}
