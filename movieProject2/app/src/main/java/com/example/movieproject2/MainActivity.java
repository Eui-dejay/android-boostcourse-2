package com.example.movieproject2;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    ScrollView mScrollView;
    TextView upRateView;
    TextView downRateView;
    ReviewerAdapter adapter;
    Button likeButton;
    Button dislikeButton;

    boolean checkLike = false;
    boolean checkDislike = false;

    boolean likeState = false;
    boolean dislikeState = false;
    int likeCount = 15;
    int dislikeCount = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeButton = (Button) findViewById(R.id.likeButton);
        dislikeButton = (Button) findViewById(R.id.dislikeButton);
        mListView = (ListView) findViewById(R.id.listView);
        mScrollView = (ScrollView) findViewById(R.id.scrollView);
        upRateView = (TextView) findViewById(R.id.upRateView);
        downRateView = (TextView) findViewById(R.id.downRateView);
        findViewById(R.id.upRateView);
        findViewById(R.id.downRateView);

        mListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mScrollView.requestDisallowInterceptTouchEvent(true);
                int action = event.getActionMasked();
                switch (action) {
                    case MotionEvent.ACTION_UP:
                        mScrollView.requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dislikeState) {
                    dislikeState = !dislikeState;
                    decrDislikeCount();
                    incrLikeCount();
                } else {
                    if (likeState) {
                        decrLikeCount();
                    } else {
                        incrLikeCount();
                    }
                }

                likeState = !likeState;
            }
        });

        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likeState) {
                    likeState = !likeState;
                    decrLikeCount();
                    incrDislikeCount();

                } else {
                    if (dislikeState) {
                        decrDislikeCount();
                    } else {
                        incrDislikeCount();
                    }
                }

                dislikeState = !dislikeState;
            }
        });


        Button button = (Button) findViewById(R.id.reviewButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "작성하기 버튼 눌림", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM,0,200);
                toast.show();
            }
        });

        ListView listView = (ListView) findViewById(R.id.listView);

        adapter = new ReviewerAdapter();

        adapter.addItem(new ReviewerItem("asd***","적당히 재밌다, 오랜만에 잠 안오는 영화 봤네요"));
        adapter.addItem(new ReviewerItem("bba***","영화가 너무 재밌어요 모두 추천드려요"));
        adapter.addItem(new ReviewerItem("asd***","적당히 재밌다, 오랜만에 잠 안오는 영화 봤네요"));
        listView.setAdapter(adapter);


    }
    public void incrLikeCount() {

            likeCount += 1;
            upRateView.setText(String.valueOf(likeCount));

            likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }
    public void decrLikeCount() {
        likeCount -= 1;
        upRateView.setText(String.valueOf(likeCount));

        likeButton.setBackgroundResource(R.drawable.ic_thumb_up);
        }
    public void incrDislikeCount() {
            dislikeCount += 1;
            downRateView.setText(String.valueOf(dislikeCount));

            dislikeButton.setBackgroundResource(R.drawable.ic_thumb_down_selected);

        }
    public void decrDislikeCount() {
        dislikeCount -= 1;
        downRateView.setText(String.valueOf(dislikeCount));

        dislikeButton.setBackgroundResource(R.drawable.ic_thumb_down);
    }


    class ReviewerAdapter extends BaseAdapter {
        ArrayList<ReviewerItem> items = new ArrayList<ReviewerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(ReviewerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return  items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ReviewerItemView view = null;

            if(convertView == null) {
                view = new ReviewerItemView(getApplicationContext());
            } else {
                view = (ReviewerItemView) convertView;
            }

            ReviewerItem item = items.get(position);
            view.setName(item.getName());
            view.setTextViewReview(item.getReviewText());

            return view;
        }
    }

}
