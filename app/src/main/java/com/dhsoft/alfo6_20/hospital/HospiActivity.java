package com.dhsoft.alfo6_20.hospital;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.Toast;

        import com.nhn.android.maps.NMapActivity;
        import com.nhn.android.maps.NMapController;
        import com.nhn.android.maps.NMapView;
        import com.nhn.android.maps.maplib.NGeoPoint;

        import org.xmlpull.v1.XmlPullParser;
        import org.xmlpull.v1.XmlPullParserException;
        import org.xmlpull.v1.XmlPullParserFactory;

        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.UnsupportedEncodingException;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.net.URLEncoder;
        import java.util.ArrayList;

public class HospiActivity extends NMapActivity {

    ArrayList<Item> items=new ArrayList<>();
    NMapView nMapView;
    EditText editText;
    ListView listView;
    MapBaseAdapter adapter;

    private final String CLIENT_ID = "hpatAdi96Zcp8WIa7IQE";


    String apikey="qjmCpJA6pIbS6gBgb%2BYdPKv9w7Eud6uiBeydXXEZv8hqQiv7jm5kGovObj0Sb%2BHmwdCswNT0SmiQL%2FQ9xsrb6A%3D%3D";
       @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospi);
        editText=findViewById(R.id.edit);
        listView=findViewById(R.id.listview);
        adapter=new MapBaseAdapter(items,getLayoutInflater());
        listView.setAdapter(adapter);

        nMapView=findViewById(R.id.nMap);
        nMapView.setClientId(CLIENT_ID); // 클라이언트 아이디 값 설정
        nMapView.setClickable(true);
        nMapView.setEnabled(true);
        nMapView.setFocusable(true);
        nMapView.setFocusableInTouchMode(true);
        nMapView.requestFocus();


    }



    public void clickIv(View v){
        items.clear();
        new Thread(){
            @Override
            public void run() {

                String ss =editText.getText().toString();

                try {
                    ss= URLEncoder.encode(ss,"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }


                String hospiuri="http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncFullDown?" +
                        "Q0=%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C" +
                        "&ORD=ADDR" +
                        "&pageNo=1" +
                        "&numOfRows=5" +
                        "&serviceKey="+apikey+
                        "&Q1=" + ss; //파싱

                try {
                    URL url=new URL(hospiuri);

                    InputStream is=url.openStream();
                    InputStreamReader isr=new InputStreamReader(is);

                    XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
                    XmlPullParser xpp=factory.newPullParser();
                    xpp.setInput(isr);

                    int eventTyp=xpp.getEventType();

                    Item item=null;

                    while (eventTyp!=XmlPullParser.END_DOCUMENT){
                        switch (eventTyp){
                            case XmlPullParser.START_DOCUMENT:
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(HospiActivity.this, "파싱", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                break;

                            case XmlPullParser.START_TAG:
                                String name=xpp.getName();
                                if(name.equals("item")){
                                    item=new Item();
                                }else if(name.equals("dutyAddr")){
                                    xpp.next();
                                    item.dutyAddr=xpp.getText();
                                }else if(name.equals("dutyName")){
                                    xpp.next();
                                    item.dutyName=xpp.getText();
                                }else if(name.equals("dutyTel1")){
                                    xpp.next();
                                    item.dutyTel1=xpp.getText();
                                }
                                break;

                            case XmlPullParser.TEXT:
                                break;
                            case XmlPullParser.END_TAG:
                                String tag=xpp.getName();
                                if(tag.equals("item")){
                                    items.add(item);
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            adapter.notifyDataSetChanged();
                                        }
                                    });
                                }
                                break;
                        }
                        eventTyp=xpp.next();
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
