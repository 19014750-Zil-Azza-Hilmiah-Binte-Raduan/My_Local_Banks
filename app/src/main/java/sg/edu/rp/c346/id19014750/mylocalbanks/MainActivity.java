package sg.edu.rp.c346.id19014750.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;
    String wordClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_lang, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here
        int id = item.getItemId();

        if(id == R.id.EnglishSelection){
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
            return true;
        }
        else if(id == R.id.ChineseSelection){
            tvDBS.setText(getString(R.string.chinesedbs));
            tvOCBC.setText(getString(R.string.chineseocbc));
            tvUOB.setText(getString(R.string.chineseuob));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if(v == tvDBS){
            wordClicked = "DBS";
        }
        else if(v == tvOCBC){
            wordClicked = "OCBC";
        }
        else if(v == tvUOB){
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(wordClicked.equalsIgnoreCase("DBS")){
            if(id == R.id.WebsiteSelection){
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.urlDBS)));
                startActivity(intentWeb);
            }
            else if(id == R.id.ContactSelection){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.noDBS)));
                startActivity(intentCall);
            }
            else if(id == R.id.FavSelection){
                if(tvDBS.getCurrentTextColor() == Color.BLACK){
                    tvDBS.setTextColor(Color.RED);
                }
                else if(tvDBS.getCurrentTextColor() == Color.RED){
                    tvDBS.setTextColor(Color.BLACK);
                }
            }
        }
        else if(wordClicked.equalsIgnoreCase("OCBC")){
            if(id == R.id.WebsiteSelection){
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.urlOCBC)));
                startActivity(intentWeb);
            }
            else if(id == R.id.ContactSelection){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.noOCBC)));
                startActivity(intentCall);
            }
            else if(id == R.id.FavSelection){
                if(tvOCBC.getCurrentTextColor() == Color.BLACK){
                    tvOCBC.setTextColor(Color.RED);
                }
                else if(tvOCBC.getCurrentTextColor() == Color.RED){
                    tvOCBC.setTextColor(Color.BLACK);
                }
            }
        }
        else if(wordClicked.equalsIgnoreCase("UOB")){
            if(id == R.id.WebsiteSelection){
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.urlUOB)));
                startActivity(intentWeb);
            }
            else if(id == R.id.ContactSelection){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.noUOB)));
                startActivity(intentCall);
            }
            else if(id == R.id.FavSelection){
                if(tvUOB.getCurrentTextColor() == Color.BLACK){
                    tvUOB.setTextColor(Color.RED);
                }
                else if(tvUOB.getCurrentTextColor() == Color.RED){
                    tvUOB.setTextColor(Color.BLACK);
                }
            }
        }

        return super.onContextItemSelected(item);
    }

}