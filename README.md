This project is copied from `https://gitlab.com/lamoboos223/spring-boot-multiple-datasource-song-project`

And I added `@Transactional(rollbackFor = {Exception.class,Throwable.class})` to rollback all transactions when the exception is thrown.