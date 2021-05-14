(ns primeira-semana.core)

(def cliente {
              :nome "Jose"
              :cpf "1010101010"
              :email "jose@jose.com"
              :cartao {
                       :numero "0123456789"
                       :cvv "123"
                       :validade "11-05-2030"
                       :limite 5000
                       }
              :compras-realizadas [
                          {:data            "11/01/2021"
                              :valor           10.8
                              :estabelecimento "Supermercado BH"
                              :categoria       "supermercado"
                           }
                          {
                              :data            "10/01/2021"
                              :valor           18.5
                              :estabelecimento "Epa"
                              :categoria       "supermercado"
                          }
                          {
                              :data            "12/01/2021"
                              :valor           15.7
                              :estabelecimento "Araujo"
                              :categoria       "farmacia"
                           }
                         {
                              :data            "18/01/2021"
                              :valor           9.2
                              :estabelecimento "Indiana"
                              :categoria       "farmacia"
                              }
                         {
                              :data            "23/01/2021"
                              :valor           39.8
                              :estabelecimento "Superpao"
                              :categoria       "padaria"
                              }
                         ]
              })

(defn imprime-compra [valor]
  (println "\nData:" (-> valor :data)
           "\nValor: R$" (-> valor :valor)
           "\nEstabelecimento: " (-> valor :estabelecimento))
  )

(defn imprime-categorias [categoria]
  (println "\n Categoria:" (-> categoria :categoria)
           "\n Total Gasto: R$" (-> categoria :total-gasto))
  )


(defn totaliza-por-categoria [[categoria itens]]
  {:categoria categoria
   :total-gasto (->> itens
                  (map #(:valor % 0))
                  (reduce +))}
)

(defn executa-categorizacao []
  (map totaliza-por-categoria
      (group-by :categoria
      (-> cliente :compras-realizadas))))

(println "COMPRAS")
(println (map imprime-compra (-> cliente :compras-realizadas)))

(println)

(println "TOTAL POR CATEGORIA")
(println (map imprime-categorias (executa-categorizacao)))


