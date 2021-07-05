package vn.edu.csc.interviewtestapp.ui.articles.detailarticle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import vn.edu.csc.interviewtestapp.databinding.FragmentDetailArticleBinding
import vn.edu.csc.interviewtestapp.di.DaggerViewModelFactory
import vn.edu.csc.interviewtestapp.ui.base.BaseFragment
import javax.inject.Inject

class DetailArticleFragment : BaseFragment(), EventHandler {
    @Inject
    lateinit var factory: DaggerViewModelFactory
    private lateinit var viewModel: DetailArticleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(DetailArticleViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailArticleBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.handler = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = DetailArticleFragmentArgs.fromBundle(requireArguments())
        viewModel.setArticle(args.article)
    }

    override fun doBack() {
        getNavController().popBackStack()
    }
}