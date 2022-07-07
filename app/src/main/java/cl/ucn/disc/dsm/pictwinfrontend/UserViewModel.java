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
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import cl.ucn.disc.dsm.pictwinfrontend.model.Pic;
import cl.ucn.disc.dsm.pictwinfrontend.model.Twin;
import cl.ucn.disc.dsm.pictwinfrontend.model.User;

/**
 * The ViewModel of User.
 */
public class UserViewModel extends AndroidViewModel {
    /**
     * The User
     */
    private final MutableLiveData<User> userLiveData = new MutableLiveData<>();

    /**
     * The Constructor
     *
     * @param application to use.
     */
    public UserViewModel(@NonNull Application application){
        super(application);
    }

    /**
     * Return the UserLiveData.
     */
    public LiveData<User> getUserLiveData(){
        return this.userLiveData;
    }

    /**
     * refresh or get the data.
     */
    public void update(){

        // running on background
        AsyncTask.execute(() -> {
                // TODO: Get data from the internet
            User user = new User(1L, "admin@ucn.cl", "admin123");

            for (long i = 0; i <= 600; i+=2){
                user.getTwins().add(buildTwin(i));
            }

            this.userLiveData.postValue(user);

        });
    }

    /**
     * Test to populate the Twins.
     */
    private static Twin buildTwin(long n){
        Pic my = new Pic();
        my.setId(n);

        Pic your = new Pic();
        your.setId(n + 1);

        Twin twin = new Twin();
        twin.setId(n);
        twin.setMy(my);
        twin.setYours(your);

        return twin;
    }

}
