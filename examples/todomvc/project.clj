(defproject todomvc-reagent "0.5.1-rc3"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.107"]
                 [reagent "0.5.1-rc3"]
                 [figwheel "0.3.7"]]

  :plugins [[lein-cljsbuild "1.0.6"]
            [lein-figwheel "0.3.7"]]

  :hooks [leiningen.cljsbuild]

  :profiles {:dev {:cljsbuild
                   {:builds {:client
                             {:figwheel {:on-jsload "todomvc.core/run"}
                              :compiler {:main "todomvc.core"
                                         :optimizations :none}}}}}

             :prod {:cljsbuild
                    {:builds {:client
                              {:compiler {:optimizations :advanced
                                          :elide-asserts true
                                          :pretty-print false}}}}}}

  :figwheel {:repl false}

  :cljsbuild {:builds {:client
                       {:source-paths ["src"]
                        :compiler {:output-dir "target/client"
                                   :output-to "target/client.js"}}}})
