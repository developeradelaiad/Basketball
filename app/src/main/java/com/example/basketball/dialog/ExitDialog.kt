package com.example.basketball.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ExitDialog:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
            builder.setTitle("Exit")
            .setMessage("Do you want to exit?")
            .setPositiveButton("yes") { _, _ -> activity?.finish() }
            .setNegativeButton("no") { dialog, _ -> dialog.cancel() }
        return builder.create()
    }
}