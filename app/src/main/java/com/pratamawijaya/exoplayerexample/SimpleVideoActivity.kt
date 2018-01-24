package com.pratamawijaya.exoplayerexample

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import kotlinx.android.synthetic.main.activity_simple.player_view

class SimpleVideoActivity : AppCompatActivity() {

    companion object {
        val VIDEO_URL = "https://archive.org/download/NellaKharismaKelinganMantan/Nella%20Kharisma%20-%20Kelingan%20Mantan.mp4"
    }

    private lateinit var player: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        setupExoPlayer()

    }

    private fun setupExoPlayer() {
        // setup track selector
        val bandwithMeter = DefaultBandwidthMeter()
        val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwithMeter)
        val trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)

        // create player
        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector)
        player_view.useController = true
        player_view.requestFocus()
        player_view.player = player

        // video source
        val videoUri = Uri.parse(VIDEO_URL)

        val dataSourceFactory = DefaultDataSourceFactory(this, "exoplayer")
        val mediaSource = ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(videoUri)

        player.prepare(mediaSource)

    }

    override fun onStop() {
        super.onStop()
        player.release()
    }
}
