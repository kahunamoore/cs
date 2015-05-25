(defproject cs "0.1.0-SNAPSHOT"
  :description "Co-op Source App"
  :url "https://www.coopsource.org"
  :license {:name "Co-op Source License"
            :url "https://www.coopsource.org/legal/cs-v0.1.html"}

  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 [org.clojure/clojurescript "0.0-3269"]     ; was 3211
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [org.toomuchcode/clara-rules "0.8.8-SNAPSHOT"]
                 ;[org.toomuchcode/clara-rules "0.9.0-SNAPSHOT"]
                 ;[reagent "0.5.0-alpha3"]
                 [rum "0.2.6"]]

  ;:repositories [["snapshots" {:url "https://oss.sonatype.org/content/repositories/snapshots/"}]]

  :plugins [[lein-cljsbuild "1.0.5"]
            [lein-figwheel "0.3.3" :exclusions [org.codehaus.plexus/plexus-utils]]]

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]
  
  :cljsbuild {
    :builds [{:id "dev"
              :source-paths ["src"]

              :figwheel { :on-jsload "cs.core/on-js-reload" }

              :compiler {:main cs.core
                         :asset-path "js/compiled/out"
                         :output-to "resources/public/js/compiled/cs.js"
                         :output-dir "resources/public/js/compiled/out"
                         :source-map-timestamp true
                         :warnings {:single-segment-namespace false}}}
             {:id "min"
              :source-paths ["src"]
              :compiler {:output-to "resources/public/js/compiled/cs.js"
                         :main cs.core                         
                         :optimizations :advanced
                         :pretty-print false}}]}

  :figwheel {
             ;; :http-server-root "public" ;; default and assumes "resources" 
             ;; :server-port 3449 ;; default
             :css-dirs ["resources/public/css"] ;; watch and update CSS

             ;; Start an nREPL server into the running figwheel process
             ;; :nrepl-port 7888

             ;; Server Ring Handler (optional)
             ;; if you want to embed a ring handler into the figwheel http-kit
             ;; server, this is for simple ring servers, if this
             ;; doesn't work for you just run your own server :)
             ;; :ring-handler hello_world.server/handler

             ;; To be able to open files in your editor from the heads up display
             ;; you will need to put a script on your path.
             ;; that script will have to take a file path and a line number
             ;; ie. in  ~/bin/myfile-opener
             ;; #! /bin/sh
             ;; emacsclient -n +$2 $1
             ;;
             ;; :open-file-command "myfile-opener"

             ;; if you want to disable the REPL
             ;; :repl false

             ;; to configure a different figwheel logfile path
             ;; :server-logfile "tmp/logs/figwheel-logfile.log" 
             })