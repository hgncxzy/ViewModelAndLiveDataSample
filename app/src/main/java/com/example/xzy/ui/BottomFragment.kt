package com.example.xzy.ui

import android.arch.lifecycle.Observer
import android.support.v4.app.Fragment
import com.example.xzy.model.AccountModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.xzy.databinding.FragmentBottomBinding

/**
 * Description :
 * Created by XuZhuYun 2019/5/9 17:07 .
 */
class BottomFragment : Fragment() {
    private var binding: FragmentBottomBinding? = null
    private var mModel: AccountModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mModel = ViewModelProviders.of(activity!!).get(AccountModel::class.java)
        mModel?.account?.observe(this,
            Observer { accountBean ->
                binding?.fragmentTextView?.text = AccountModel.getFormatContent(
                    accountBean?.name,
                    accountBean?.phone,
                    accountBean?.blog
                )
            })
    }
}
