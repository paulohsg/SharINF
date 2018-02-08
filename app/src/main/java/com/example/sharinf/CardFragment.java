package com.example.sharinf;



        import android.content.ContentResolver;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.support.v7.widget.Toolbar;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;
        import java.util.ArrayList;



public class CardFragment extends Fragment {

    ArrayList<Object> listitems = new ArrayList<>();
    RecyclerView MyRecyclerView;
    String Wonders[] = {"Chichen Itza","Christ the Redeemer","Great Wall of China","Machu Picchu","Petra","Taj Mahal","Colosseum"};
    int  Images[] = {R.drawable.statistics,R.drawable.ranking,R.drawable.great_wall_of_china,R.drawable.machu_picchu,R.drawable.petra,R.drawable.taj_mahal,R.drawable.colosseum};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeList();
        getActivity().setTitle("Início");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_card, container, false);
        MyRecyclerView = (RecyclerView) view.findViewById(R.id.cardView);
        MyRecyclerView.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        if (listitems.size() > 0 & MyRecyclerView != null) {
            MyRecyclerView.setAdapter(new MyAdapter(listitems));
        }
        MyRecyclerView.setLayoutManager(MyLayoutManager);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private ArrayList<Object> list;
        private final int RANKING = 0, CHART = 1;

        public MyAdapter(ArrayList<Object> Data) {
            list = Data;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
//            View view = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.recycle_items, parent, false);
//            RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(view);
//            return holder;

            RecyclerView.ViewHolder viewHolder;
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            switch (viewType) {
                case RANKING:
                    View v1 = inflater.inflate(R.layout.recycle_items, parent, false);
                    viewHolder = new MyViewHolder1(v1);
                    break;
                case CHART:
                    View v2 = inflater.inflate(R.layout.recycle_items2, parent, false);
                    viewHolder = new MyViewHolder2(v2);
                    break;
                default:
                    View v = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                    viewHolder = viewHolder = new MyViewHolder1(v);
                    break;
            }
            return viewHolder;

        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

//            holder.titleTextView.setText(list.get(position).getCardName());
//            holder.coverImageView.setImageResource(list.get(position).getImageResourceId());
//            holder.coverImageView.setTag(list.get(position).getImageResourceId());
//            holder.likeImageView.setTag(R.drawable.ic_like);


            switch (holder.getItemViewType()) {
                case RANKING:
                    MyViewHolder1 vh1 = (MyViewHolder1) holder;
                    configureViewHolder1(vh1, position);
                    break;
                case CHART:
                    MyViewHolder2 vh2 = (MyViewHolder2) holder;
                    configureViewHolder2(vh2, position);
                    break;
                default:
                    MyViewHolder2 vh = (MyViewHolder2) holder;
                    configureViewHolder2(vh, position);
                    break;
            }

        }

        private void configureViewHolder1(MyViewHolder1 vh1, int position) {
            WonderModel wonder = (WonderModel) list.get(position);
            if (wonder != null) {
                vh1.titleTextView.setText(wonder.getCardName());
                vh1.coverImageView.setImageResource(wonder.getImageResourceId());
                vh1.coverImageView.setTag(wonder.getImageResourceId());
                vh1.likeImageView.setTag(R.drawable.ic_like);
            }
        }

        private void configureViewHolder2(MyViewHolder2 vh2, int position) {
            WonderModel2 wonder = (WonderModel2) list.get(position);
            if (wonder != null) {
                vh2.titleTextView.setText(wonder.getCardName());
                vh2.coverImageView.setImageResource(wonder.getImageResourceId());
                vh2.coverImageView.setTag(wonder.getImageResourceId());
                vh2.likeImageView.setTag(R.drawable.ic_like);
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (list.get(position) instanceof WonderModel) {
                return RANKING;
            } else if (list.get(position) instanceof WonderModel2) {
                return CHART;
            }
            return -1;
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public ImageView coverImageView;
        public ImageView likeImageView;
        public ImageView shareImageView;

        public MyViewHolder1(final View v) {
            super(v);
            titleTextView = (TextView) v.findViewById(R.id.titleTextView);
            coverImageView = (ImageView) v.findViewById(R.id.coverImageView);
            likeImageView = (ImageView) v.findViewById(R.id.likeImageView);
            shareImageView = (ImageView) v.findViewById(R.id.shareImageView);
            likeImageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {


                    int id = (int)likeImageView.getTag();
                    if( id == R.drawable.ic_like){

                        likeImageView.setTag(R.drawable.ic_liked);
                        likeImageView.setImageResource(R.drawable.ic_liked);

                        Toast.makeText(getActivity(),titleTextView.getText()+" added to favourites",Toast.LENGTH_SHORT).show();

                    }else{

                        likeImageView.setTag(R.drawable.ic_like);
                        likeImageView.setImageResource(R.drawable.ic_like);
                        Toast.makeText(getActivity(),titleTextView.getText()+" removed from favourites",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            shareImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                            "://" + getResources().getResourcePackageName(coverImageView.getId())
                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int)coverImageView.getTag()));


                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
                    shareIntent.setType("image/jpeg");
                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));

                }
            });


            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    v.getContext().startActivity(new Intent(v.getContext(),ActivityChart.class));
                }
            });
        }
    }


    public class MyViewHolder2 extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public ImageView coverImageView;
        public ImageView likeImageView;
        public ImageView shareImageView;

        public MyViewHolder2(final View v) {
            super(v);
            titleTextView = (TextView) v.findViewById(R.id.titleTextView);
            coverImageView = (ImageView) v.findViewById(R.id.coverImageView);
            likeImageView = (ImageView) v.findViewById(R.id.likeImageView);
            shareImageView = (ImageView) v.findViewById(R.id.shareImageView);
            likeImageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {


                    int id = (int)likeImageView.getTag();
                    if( id == R.drawable.ic_like){

                        likeImageView.setTag(R.drawable.ic_liked);
                        likeImageView.setImageResource(R.drawable.ic_liked);

                        Toast.makeText(getActivity(),titleTextView.getText()+" added to favourites",Toast.LENGTH_SHORT).show();

                    }else{

                        likeImageView.setTag(R.drawable.ic_like);
                        likeImageView.setImageResource(R.drawable.ic_like);
                        Toast.makeText(getActivity(),titleTextView.getText()+" removed from favourites",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            shareImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                            "://" + getResources().getResourcePackageName(coverImageView.getId())
                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int)coverImageView.getTag()));


                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
                    shareIntent.setType("image/jpeg");
                    startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));

                }
            });


            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    v.getContext().startActivity(new Intent(v.getContext(),ListaDeAlunosActivity.class));
                }
            });
        }
    }

    public void initializeList() {
//        listitems.clear();

            WonderModel item = new WonderModel();
            item.setCardName("Estatíscas");
            item.setImageResourceId(R.drawable.statistics);
            item.setIsfav(0);
            item.setIsturned(0);
            listitems.add(item);


        WonderModel2 item2 = new WonderModel2();
        item2.setCardName("Ranking");
        item2.setImageResourceId(R.drawable.ranking);
        item2.setIsfav(0);
        item2.setIsturned(0);
        listitems.add(item2);






    }
}
