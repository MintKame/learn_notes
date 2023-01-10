+ pool advantage
  + programmer:  convenient
  + performance: reuse thread for diff runnable
  ![](_img_pool.png)


![](_img_pool_policy.png)
+ how to handle execute(runnable)

|condition |how|
|---|---|
|core pool not full|create thread to run|
|queue not full|put runnable in queue|
|max pool not full|create thread to run|
|all full|reject|  


+ 4 reject policy
![](_img_pool_reject.png)


+ problem of Executors
![](_img_pool_problem.png)