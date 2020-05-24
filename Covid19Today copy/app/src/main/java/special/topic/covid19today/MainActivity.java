package special.topic.covid19today;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import special.topic.covid19today.ui.dashboard.DashboardFetch;
import special.topic.covid19today.ui.dashboard.GraphFetch;
import special.topic.covid19today.ui.home.HomeFetch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
               R.id.navigation_chatbot, R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_emergency)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        HomeFetch homeProcess = new HomeFetch();
        homeProcess.execute();
        DashboardFetch tableProcess = new DashboardFetch();
        tableProcess.execute();
        GraphFetch graphProcess = new GraphFetch();
        graphProcess.execute();
    }

}
