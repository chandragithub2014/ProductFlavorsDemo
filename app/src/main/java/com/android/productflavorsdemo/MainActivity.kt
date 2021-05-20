package com.android.productflavorsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.productflavorsdemo.adapter.PostsAdapter
import com.android.productflavorsdemo.model.PlaceHolderPostsDataModel
import com.android.productflavorsdemo.repository.PlaceHolderRepository
import com.android.productflavorsdemo.viewmodels.PlaceHolderViewModel
import com.android.productflavorsdemo.viewmodels.PlaceHolderViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var placeHolderViewModel: PlaceHolderViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            //    println("Displaying Info ${PlaceHolderRepository().displayInfo()}")
        initViewModel()
    }

    private  fun initViewModel(){
        var placeHolderViewModelFactory = PlaceHolderViewModelFactory()
        placeHolderViewModel = ViewModelProvider(this,placeHolderViewModelFactory).get(
            PlaceHolderViewModel::class.java)
        // placeHolderViewModel.fetchPostsFromService()
        placeHolderViewModel.fetchPostsAndComments()
    }


    override fun onResume() {
        super.onResume()
        observePostsResponse()
        observeCommentsResponse()
        observeLoadStatus()
    }

    private fun observePostsResponse(){
        placeHolderViewModel.fetchPostsLiveData().observe(this, Observer {
            it?.let {
             //   println("Received Posts is $it")
                populatePostsAdapter(it)
            }
            //  val postsList = it
        //    populatePostsAdapter(it)

            // placeHolderViewModel.fetchCommentsFromService()

        })
    }

    private fun observeCommentsResponse(){
        placeHolderViewModel.fetchCommentsLiveData().observe(this, Observer {
       //     populateCommentsAdapter(it)
            it?.let {
            //    println("Received Comments is $it")
            }

        })
    }

    private fun observeLoadStatus(){
        placeHolderViewModel.fetchLoadStatus().observe(this, Observer {
            if (!it) {
                println(it)
                loading_widget.visibility = View.GONE
            }else{
                loading_widget.visibility = View.VISIBLE
            }
        })
    }
    private fun populatePostsAdapter(postsList: PlaceHolderPostsDataModel){
        val postsAdapter = PostsAdapter(this,postsList)
        val layoutManager = LinearLayoutManager(this)
        post_list.layoutManager = layoutManager
        post_list.adapter = postsAdapter
        post_list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        postsAdapter.notifyDataSetChanged()

    }
}