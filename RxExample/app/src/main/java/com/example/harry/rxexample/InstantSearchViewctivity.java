package com.example.harry.rxexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.harry.rxexample.model.Person;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static android.R.layout.simple_list_item_1;

public class InstantSearchViewctivity extends AppCompatActivity {
    private EditText tvSearch;
    private RecyclerView rvSearch;
    private List<Person> persons;
    private PersonAdapter personAdapter;
    private List<Person> searchPersons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instant_search_viewctivity);
        tvSearch = (EditText) findViewById(R.id.tvSearch);
        rvSearch = (RecyclerView) findViewById(R.id.rvSearch);
        persons = DummyFactory.getPersons();

        rvSearch.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        personAdapter = new PersonAdapter();
        searchPersons = new ArrayList<>();
        rvSearch.setAdapter(personAdapter);
        personAdapter.clearAndAddAll(persons);

        RxTextView.afterTextChangeEvents(tvSearch)
                .debounce(2, TimeUnit.SECONDS)
                .map(event -> event.editable().toString().toLowerCase())
                .switchMap(new Func1<String, Observable<List<Person>>>() {
                    @Override
                    public Observable<List<Person>> call(final String s) {
                        return Observable.from(persons).subscribeOn(Schedulers.computation())
                                .filter(person -> s.equals("") || person.getName().toLowerCase().contains(s)).toList();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(persons -> {
                    personAdapter.clearAndAddAll(persons);
                }, throwable -> {
                    Log.d("Debug", "Error");
                });


    }

    private class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
        private List<Person> persons;

        public PersonAdapter() {
            persons = new ArrayList<>();
        }

        public void clearAndAddAll(List<Person> persons) {
            this.persons.clear();
            this.persons.addAll(persons);
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(simple_list_item_1, null));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tvData.setText(persons.get(position).getName());
        }

        @Override
        public int getItemCount() {
            return this.persons.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView tvData;

            public ViewHolder(View itemView) {
                super(itemView);
                tvData = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }
    }
}
