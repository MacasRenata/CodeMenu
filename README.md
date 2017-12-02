
<h1><a></a>DEV2</h1>
<p>Esse é o repositório principal do trabalho de Desenvolvimento de Sistemas 2.</p>
<h1>Responsáveis</h1>
<p>Professor(res) Responsável(veis):</p>
<pre><code>1. Régio Michelin
1. Daniela Remião
1. Fabio Pereira
</code></pre>
<p>Grupo de Desenvolvimento:</p>
<pre><code>1. Renata Maçãs
2. Gabriel Liesenfield
3. Cristian Weber
4. Marcio Zimmermann
5. Anderson 
</code></pre>
<p>Instituição(ões) Responsável(eis):</p>
<pre><code>1. Instituto Federal de Educação Ciência e Tecnologia do Rio Grande do Sul, Campus Restinga
</code></pre>
<h1><a ></a>Sobre o Projeto</h1>
<p>O foco do projeto é o desenvolvimento de uma aplicação Mobile e um Webservice. Essa aplicação tem como objetivo auxiliar restaurantes que desejam inovar na prestação de serviço e de forma dinamica economizar tempo para a solicitação e recebimento de pedidos do estabelecimento. O foco da Aplicação é um cardapio dinamico que faz interação com serviços do restaurante pelo webservice</p>
<h1>Arquitetura</h1>
<pre><code>1. Pasta App:
    1.1: Contem os arquivos necessários para a configuração e desenvolvimento do Mobile.
    1.2: Principais Tecnologias: Java, XML, Rest, Retrofit. 
2. Pasta Webservice:
    1.2: Servidor Glassfish que fornece os dados para o Aplicativo.
    1.3: Principais Tecnologias: Java, MySql, Hibernate, Rest, Maven.
</code></pre>
<h1>Dependências Necessárias</h1>
<p>Para o funcionamento do projeto você ter instalado no seu sistema operacional tais dependências:</p>
<pre><code>1. Android Studio (Download: <a>https://developer.android.com/studio/index.html?hl=pt-br</a>
2. NetBeans
3. JDK / SDK (Download: <a>http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html</a>
4. Sistema Android em um smartphone ou emulador em um outro sistema operacional
</code></pre>
<h1>Instalando Dependências Necessárias (GNU/Linux)</h1>
<pre><code>1. Instale o JDK/SDK no seu Sistema Operacional:
</code></pre>
  <pre><code>
  - Copiar o arquivo de instalação para o diretório de sua preferência com o comando abaixo
  </code></pre>
   <blockquote>
    $ cp jdk-<versão>.tar.gz <caminho-completo-do-seu-diretório>
    </blockquote>
  <pre><code> 
  - Mudar para o diretório de sua preferência
  </code></pre>
   <blockquote>
    $ cd /<caminho-completo-do-seu-diretório>
       </blockquote>
   <pre><code>
  - Descompactar o arquivo
  </code></pre>
   <blockquote>
    $ tar -zvxf jdk-<versão>.tar.gz
      </blockquote>
    <pre><code>
Outra maneira de instalar o JDK no Linux é usando o programa apt-get presente nas distribuições Linux. O apt-get é um programa que permite a instalação e a atualização de pacotes (programas e bibliotecas) de maneira simples e fácil. A Listagem 2 mostra como instalar o JDK usando o apt-get.
</code></pre>
 <pre><code>
Listagem 2. Instalação do JDK no Linux usando apt-get
</code></pre>
   <blockquote>
    $ sudo add-apt-repository ppa:webupd8team/java
    $ sudo apt-get update
    $ sudo apt-get install oracle-java8-installer
      </blockquote>
    <pre><code>
O comando add-apt-repository adiciona o local ppa:webupd8team/java no repositório do apt-get. Em seguida o repositório é atualizado com o comando apt-get update. O comando apt-get install irá instalar o pacote JDK 8 da Oracle.
</code></pre>
<pre><code>2. Instale o Android Studio no seu Sistema Operacional:
</code></pre>
<pre><code>
Passo 1. Abra um terminal usando o Dash ou pressionando as teclas Ctrl+Alt+T;
Passo 2. Se ainda não tiver, adicione o repositório do programa com este comando
</code></pre>
<blockquote>
sudo add-apt-repository ppa:maarten-fonville/android-studio
  </blockquote>
  <pre><code>
Passo 3. Atualize o APT com o comando:
</code></pre>
<blockquote>
sudo apt-get update
  </blockquote>
  <pre><code>
Passo 4. Agora instale o programa com o comando:
</code></pre>
<blockquote>
sudo apt-get install android-studio
</blockquote>
<pre><code>
Passo 5. Se você quiser instalar uma versão “Preview”, use o comando abaixo;
</code></pre>
<blockquote>
sudo apt-get install android-studio-preview
</blockquote>
<pre><code>
Para instalar o Android Studio no Ubuntu e derivados, faça o seguinte:
Passo 1. Abra um terminal usando o Dash ou pressionando as teclas Ctrl+Alt+T;
Passo 2. Se ainda não tiver, adicione o repositório do programa com este comando ou use esse tutorial;
</code></pre>
<blockquote>
sudo apt-add-repository ppa:paolorotolo/android-studio
  </blockquote>
Passo 3. Atualize o APT com o comando:
</code></pre>
<blockquote>
sudo apt-get update
  </blockquote>
  <pre><code>
Passo 4. Agora instale o programa com o comando:
</code></pre>
<blockquote>
sudo apt-get install android-studio
  </blockquote> 
<h1>Instalando Dependências Necessárias (Windows)</h1>
<pre><code>1. Instale o JDK/SDK no seu Sistema Operacional:
</code></pre>
<pre><code>
1.Após o download do arquivo de instalação ter sido concluído, a instalação do JDK é feita executando-se o programa de instalação. 
2.O nome do arquivo de instalação para o Windows tem o formato jdk-<versão>-windows-<arquitetura>.exe, onde <versão> é a versão do JDK e arquitetura pode ser 32 ou 64 bits, por exemplo, jdk-8u66-windows-x64.exe. 
3.Para instalar o JDK no Windows, executar o programa de instalação e clicar no botão Next em todas as telas apresentadas. O processo é simples e rápido.
</code></pre>
<pre><code>2. Instale o Android Studio no seu Sistema Operacional:
</code></pre>
<pre><code>
1.Execute o arquivo .exe que você baixou .
2.Siga o assistente de configuração para instalar o Android Studio e todas as ferramentas do SDK necessárias.
3.Em alguns sistemas Windows, o script de inicialização não encontrará o local de instalação do JDK. Se ocorrer esse problema, será preciso definir uma variável de ambiente indicando o local correto.
3.1.Selecione Start menu > Computer > System Properties > Advanced System Properties. 
3.1.2.Em seguida, abra a guia Advanced > Environment Variables e adicione uma nova variável de sistema, JAVA_HOME, que aponta para a pasta do JDK. Por exemplo, C:\Program Files\Java\jdk1.8.0_77.
</code></pre>
