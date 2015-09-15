
/* global url, React */

/** @jsx React.DOM */
/* 
 * JS for index.html . Uses AJAX and JQUERY to load get the 
 * Bitcoin Node status. 
 */


      var CSSTransitionGroup = React.addons.CSSTransitionGroup;
      var INTERVAL = 5000;
  
          
      var statusServiceURL = 'http://localhost:8080/NodeStatus';
      var latestNodeStatus;



      var AnimateDemo = React.createClass({
        getInitialState: function() {
            $.get( "http://localhost:8080/NodeStatus", function( data ) {
                latestNodeStatus= data.toString();
                this.setState({latestNodeStatus: "latestNodeStatus"});
 
});
             
          return {start: 0};
        },

        componentDidMount: function() {
            
         
          this.interval = setInterval(this.tick, INTERVAL);
         
        },

        componentWillUnmount: function() {
          clearInterval(this.interval);
        },

        tick: function() {
          this.setState({start: this.state.start + 1});
          $.get( "http://localhost:8080/NodeStatus", function( data ) {
                latestNodeStatus= data.toString();
                this.setState({latestNodeStatus: "latestNodeStatus"});
          });
            
        },

         render: function() {
          var children = [];
          var pos = 0;
          var colors = ['red', 'gray', 'blue'];
          for (var i = this.state.start; i < this.state.start + 3; i++) {
            var style = {
              left: pos * 128,
              background: colors[i % 3]
            };
            pos++;
            var currentState ;
            $.get( "http://localhost:8080/NodeStatus", function( data ) {
               latestNodeStatus= data.toString();
               this.setState({latestNodeStatus: "latestNodeStatus"});
                
            });
            
            children.push(<div key={i} className="animateItem" style={style}>{latestNodeStatus}</div>);
            }
          return (
            <CSSTransitionGroup
              className="animateExample"
              transitionName="example">
              {children}
            </CSSTransitionGroup>
           
           
          );
        }
      });

      React.render(
        <AnimateDemo />,
        document.getElementById('container')
      );
