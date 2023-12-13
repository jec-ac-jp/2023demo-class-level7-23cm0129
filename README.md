# 【第7回】フレームワークを使ったプログラミング
## テーマ
1. Serviceクラスについて

## 開発環境について
* この演習では、Codespacesと呼ばれるサービスを使って開発を行います。
* ブラウザ上で動作する開発環境です、インストール不要で使う事ができます。

## Codespacesで実行してみよう
* 第一回で実施した[手順](/Codespacesの実行手順.md)を参照してください。

## Serviceクラスについて学習
1. `Let's try!`を押します。<br>
![image](https://user-images.githubusercontent.com/32722128/155075778-c7ad85ce-442a-40dd-ab4f-5f2cc6da30fd.png)

2. コメント一覧とコメント投稿を行う画面が表示される事を確認しましょう。<br>
![image](https://user-images.githubusercontent.com/32722128/155110313-51f72a46-7f17-4858-b273-1fc3df025e2f.png)

3. なにも入力せずに検索ボタンを押してください、コメントが何も表示されない事を確認してください。<br>
![image](https://user-images.githubusercontent.com/32722128/155110746-98b6b62a-4fbe-4734-878a-6784cb4b2f8e.png)

4. 「田中」と入力し検索ボタンを押してください。<br>
![image](https://user-images.githubusercontent.com/32722128/155110854-68a0cfec-95cb-494c-abd7-030475f9ebc5.png)

5. 確認が終わったら、タブを閉じましょう<br>
![image](https://user-images.githubusercontent.com/32722128/150733257-a1056c19-1b24-412b-8bfc-a6063e75c785.png)

6. デバック実行中ですので、停止ボタンを押して、デバック実行を停止しましょう。<br>
![image](https://user-images.githubusercontent.com/32722128/150748527-d7121765-5142-4f5a-9769-33c0c23627a4.png)

## 解説
### Serviceクラスについて
* ControllerクラスとDAOクラス(DB操作を担当するクラス)の間に入ってビジネスロジックを担当するのがServiceクラスです。
* 一般的にControllerクラスにビジネスロジックを書く事はよくないとされています、学習用に作成するプログラムは大したビジネスロジックは必要ではありませんが、  
実際に世の中で使われているシステムのビジネスロジックは複雑なものとなっているため、分けて置く必要があります。 
[ビジネスロジックとは？](https://wa3.i-3-i.info/word13666.html)
それぞれのクラスの責任分解点はプロジェクトによって異なりますが、一例として、以下のように分けられます。
  * Controller
    * requestのルーティング
    * バリデーションチェック
    * リクエストをServiceが適切に扱えるよう変換(フォームクラスをEntityクラスに)
  * Service
    * ビジネスルール(ロジック)に関わる処理を記述する。 

* コメント一覧を表示する処理を追って説明します。

1. `Step7Controlle`クラスの`index`メソッドから処理が開始されます。
![image](https://user-images.githubusercontent.com/32722128/155083396-069cbbd4-d2cb-448d-8434-1d6b921d2b43.png)

2. `CommentService`クラスの`getAll`メソッドを用いて、コメントの一覧を取得しています。
![image](https://user-images.githubusercontent.com/32722128/155083431-d0f3928b-7e15-499c-a7e1-8e2db27bf2b5.png)

3. `getAll`メソッドでは、daoを用いてDBから一覧を取得していますが、daoについては次回解説しますので今回は触れません。
![image](https://user-images.githubusercontent.com/32722128/155423210-ce707d89-aab3-433d-a8bc-24dec0259e27.png)


### インタフェースと実装クラスについて
CommentServiceは、インタフェースである`CommentService`とその実装クラスである`CommentServiceImpl`クラスで成り立っています。  
インタフェースには、実装クラスの概要となる内容を記載し、実装クラスではその概要に従って実装を行います。  
インターフェイスには定数とメソッドのみが定義されます、インターフェイスを実装するクラスでは必ず、インターフェイスで定義されたメソッドを実装する必要があります。  
どのインターフェイスを実装するかは、implementsを使用して指定します。  
![image](https://user-images.githubusercontent.com/32722128/155421735-6a408009-a2f9-41a6-a5a2-cadf9d69c923.png)  
またクラス名の末尾にimplementsを示す、「Impl」とつける事が一般的です。  
メソッドの処理内容を変更する場合は、末尾に「Impl」のついたクラスを探し変更を行いましょう。

## 演習level2 step7
1. STEP-7のページを開きます、検索欄に何も入れずに検索した場合、全件表示されるよう、Serviceに処理を追加してください。<br>
![image](https://user-images.githubusercontent.com/32722128/155084351-ccf283c8-a3c2-4a36-b709-382c86ff275f.png)

## ヒント
1. `CommentServiceImpl`クラスの、`getCommentSerchByname`メソッドに、検索欄に何も入力されなかった場合は全件検索されるよう分岐処理を追加しましょう。
nameの有無によって、使用するDAOのメソッド変えるようにしましょう。
* 編集先:`~/src/main/java/com/classroom/assignment/service/CommentServiceImpl.java`

## テスト
* 提出前に回答があっているかテストしてみましょう。

1. `~/src/test/java/com/classroom/assignment/controller/api/Step7ControllerTests.java`を開きます。

2. クラス名の前の再生ボタンをクリックします。(画面コピーは一度テスト実施済みのためチェックマークに変わっています。)
![image](https://user-images.githubusercontent.com/32722128/155107975-93155fa9-6892-4f52-ab67-db625683aa56.png)

3. 再生ボタンがチェックマークに変わればテスト成功です！

## 課題の提出
* 課題の提出は第一回と同じ[操作](/課題の提出手順.md)のコミット・プッシュ・プルリクエストを実施しましょう。
