# EngLib

##1 core:  3/5/2021

	###class:
	
		+ **pool** (2mem) : att: PriorQueue<Vocab> = vocab; num_vocab, (enum) CompleteState{DONE, FAILED} => Hao-(11/05/2021)
		
			=> userPool: store user state 
			
				. case: add(new_vocab) -> isExist(new_vocab): check ?, why?
				
			=> refPool: refference (load file json) => GET API (done)
				
		+ **vocab** (1mem) => Hao-(15/05/2021)
		
			=> att = wotdList

			=> method: 

				. parseString

		+ **Account** (1mem: Phuoc)-(15/05/2021)

			. Account.kt

			. AccountViewModel.kt

			. AccountViewModelFactory.kt

			. AccountSingleton.kt
			
			. file to store localMem (csv/json/xml/...)

##2 workflow: 10/5/2021

=> nullable_case

	###Utils: 

		+ **Store**: 

			=> LOADprocess

			=> STOREprocess

		+ **Configuration**: => export file config (1mem: Khang)-(20/05/2021)

			. Configuration.kt

			. ConfigurationViewModel.kt

			. ConfigurationViewModelFactory.kt

			. ConfigurationSingleton.kt

	###Activity (KOTLIN file, LAYOUT file):

		+ **Introduce**: (1mem: Quyen)-(11/05/2021)

			+ SplashActivity (contains Logo: name)

		+ **Login**: (2mem: Phuoc, Hao)

			+ **SignupActivity** (contains gmail, username, password) - (1mem: Phuoc)-(20/05/2021)

				. post api to ggsheet
				
				. transfer to: LoginActivity

			+ **LoginActivity** (contains username, password) - (1mem: Phuoc)-(20/05/2021)
			
				. get api from ggsheet 
				
				-> authen: correct 

				. transfer to: QuestionFragment (store data of account)
				
				-> authen: fail 
				
				. transfer to: DialogFrament

			+ **QuestionFragment** - (1mem: Hao)-(25/05/2021)

				. (num_quest follow file config) contains FAILED_button

				. null_case: user_list = null => notification.INIT (enum)

				+ **ABCDActivity** (ABCD)

				+ **FillActivity** (fill)

				+ **BoolActivity** (T/F)

				. loop follow numQuest in config file

			+ *NotificationDialog*: - (1mem: Quyen)-(22/05/2021)

				. transfer to: HomeActivity

				. PASSED 

				. FAILED:

					- wrong reply

					- click btnGiveup  => Update CompleteState => devolope (score)

				. INIT: 

					=> ask to add: transfer to: HomeActivity

						yes => setup: RegisterFragment

						no  => setup: blankFragment (ex: user)

		+ **HomeActivity**: (3mem)
			
			layout: navigationBar => action: trasfer to:

			+ **btnRegister** 	-> transfer to: **RegisterFragment** (2mem: Thuan, Khang)-(22/05/2021)

				. add new word into userPool 	

				=> input: 	priKey (edt)
				
				=> check by btnRegister

					+ newWord.verify() | verify(priKey: String) : check new word whether exists in dictionaryapi or not (support: Hao)

						- output: 
						
						NOK - DialogErrorNotify/ tvErrorNotify => loop

						OK 	- newWord.addUserPool(userPool: UserPool) | userPool.addNew(priKey: String) (authen for account - support: Phuoc)

					+ Display 	=> output: 	vocab : word_item_view 

			+ **btnPrint** 		-> transfer to: **PrintFragment** (2mem: Khang, Hao)-(20/05/2021)

				. using:

					+ ui: 			ReclyclerView

					+ dataset:		<>pool

					+ item:			word 

					+ itemAdapter:		*PoolAdapter* contains *ViewHolder* (using for itemView)

					+ layoutManager:	LinearLayoutManager / Grid

					=> itemView:		word_item_view (ConstrainLayout contains {tvPriKey; tvDescription; btnPriorityStar})

						=> set onClick: show *DetailsItemDialog*

				. *ListUserReclyclerView*: print(userPool)

				. *ListDictReclyclerView*: print(refPool) 

					=> *DetailsItemDialog* contains: btnAdd using to add this word into userPool 

			+ **btnSetup** 		-> transfer to: **SetupFragment** (1mem: Khang)-(20/05/2021)

				. waitTime for displaying question (waitTimeQuest)

				. number of questions (numQuest)

				..

				=> use Config class => modify file config (csv)

			+ **btnDevelop**	:  New_Feature (score)



##3 git, github (2mem: Phuoc, Khang) 5/4/2021

 => entire process

##4 report (1mem: Hao) 1/6/2021

 => document 		(word)

 => presentation 	(powerpoint)

##5 unitest (1mem: Thuan) 12/4/2021

=====================================================================================================================

Description's Project

store_pool

fisrt: init userPool

using time: 

(Act)Login: 

=> add new word = galaxy (pri)

compare refPool => true: store userPool 

---STOREprocess---

=> cur_state => save local (exports file user_wordList) => pre_state = cur_state (contains file user_wordList)



=====

second: init userPool = new  (pre_state)



user_list contains only priKey

---LOADprocess---

loop(num_vocab)
	vocab = query(priKey)

	userPool.add(vocab)

using time: login: display question(pri) [follow essential]

quest (mean?)

display: priKey

=> ABCD: mean

=> fill: non

=> t/f: 

quest (pri?)

display: mean

=> ABCD: pri

=> fill: 

=> t/f: {num_vocab: 20, 

	 vocab:[priKey: mean,

		mean: to express or represent something such as an idea, thought, or fact, 

		question: [mean?: [ABCD: yes, fill: no, t/f: yes]; priKey?: [ABCD: yes, fill: no, t/f: yes]],

		essential: high,

		etc: sub key (synonym)],

	}


